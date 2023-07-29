import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const url = "http://localhost:8080/api/employee";

const initialState = {
  isOpen: false,
  isLoading: false,
  profile: {},
};

export const registerUser = createAsyncThunk(
  "signup/registerUser",
  async (payload, thunkAPI) => {
    try {
      const resp = await axios.post(url, payload);
      return resp.data;
    } catch (err) {
      return thunkAPI.rejectWithValue("Something went wrong");
    }
  }
);

const signUpSlice = createSlice({
  name: "signUp",
  initialState,
  reducers: {
    openSignUpModal: (state) => {
      state.isOpen = true;
    },
    closeSignUpModal: (state) => {
      state.isOpen = false;
    },
  },
  extraReducers: (builder) => {
    builder.addCase(registerUser.fulfilled, (state, action) => {
      state.isLoading = false;
      state.profile = action.payload;
      state.isOpen = false;
    });
    builder.addCase(registerUser.pending, (state) => {
      state.isLoading = true;
    });
    builder.addCase(registerUser.rejected, (state, action) => {
      state.isLoading = false;
      console.log(action);
    });
  },
});

export const { openSignUpModal, closeSignUpModal } = signUpSlice.actions;
export default signUpSlice.reducer;
