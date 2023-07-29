import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const url = "https://course-api.com/react-useReducer-cart-project";

const initialState = {
  isOpen: false,
  isLoading: false,
  profile: {},
};

export const getAuthentication = createAsyncThunk(
  "login/getAuthentication",
  async (payload, thunkAPI) => {
    try {
      const resp = await axios(url);
      return resp.data;
    } catch (err) {
      return thunkAPI.rejectWithValue("Something went wrong");
    }
  }
);

const modalSlice = createSlice({
  name: "modal",
  initialState,
  reducers: {
    openModal: (state) => {
      state.isOpen = true;
    },
    closeModal: (state) => {
      state.isOpen = false;
    },
  },
  extraReducers: (builder) => {
    builder.addCase(getAuthentication.fulfilled, (state, action) => {
      state.isLoading = false;
      state.profile = action.payload;
      state.isOpen = false;
    });
    builder.addCase(getAuthentication.pending, (state) => {
      state.isLoading = true;
    });
    builder.addCase(getAuthentication.rejected, (state, action) => {
      state.isLoading = false;
      console.log(action);
    });
  },
});

export const { openModal, closeModal } = modalSlice.actions;
export default modalSlice.reducer;
