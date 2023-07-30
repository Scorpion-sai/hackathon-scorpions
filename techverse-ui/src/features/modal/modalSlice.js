import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const url = "http://localhost:8080/api/auth/login";

const initialState = {
  isOpen: false,
  isLoading: false,
  isAuthenticated: false,
  profile: {},
};

export const getAuthentication = createAsyncThunk(
  "login/getAuthentication",
  async (payload, thunkAPI) => {
    try {
      const resp = await axios.post(url, payload);
      const response = { ...resp.data, ...payload };
      return response;
    } catch (err) {
      return thunkAPI.rejectWithValue("Something went wrong");
    }
  }
);

// New action for logout
export const logout = createAsyncThunk("login/logout", async () => {
  // Perform any logout-related operations, like clearing tokens or session data
  // For now, we will simply return an empty object to reset the authentication state
  return {};
});

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
      state.isAuthenticated = true; // Set isAuthenticated to true after successful login
      state.isOpen = false;
    });
    builder.addCase(getAuthentication.pending, (state) => {
      state.isLoading = true;
    });
    builder.addCase(getAuthentication.rejected, (state, action) => {
      state.isLoading = false;
      console.log(action);
    });
    builder.addCase(logout.fulfilled, (state, action) => {
      state.isAuthenticated = false; // Set isAuthenticated to false after logout
      state.profile = {}; // Clear the profile data
    });
  },
});

export const { openModal, closeModal } = modalSlice.actions;
export default modalSlice.reducer;
