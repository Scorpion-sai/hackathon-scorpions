import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const url = "http://localhost:8080/api/project";

const initialState = {
  isOpen: false,
  isLoading: false,
  profile: {},
};

export const addProject = createAsyncThunk(
  "project/addProject",
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

const modalSlice = createSlice({
  name: "project",
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
    builder.addCase(addProject.fulfilled, (state, action) => {
      state.isLoading = false;
      state.profile = action.payload;
      state.isOpen = false;
    });
    builder.addCase(addProject.pending, (state) => {
      state.isLoading = true;
    });
    builder.addCase(addProject.rejected, (state, action) => {
      state.isLoading = false;
      console.log(action);
    });
  },
});

export const { openModal, closeModal } = modalSlice.actions;
export default modalSlice.reducer;
