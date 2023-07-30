import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const url = "http://localhost:8080/api/employees";

const initialState = {
  isLoading: false,
  peopleDetail: [],
};

export const getAllPeople = createAsyncThunk(
  "people/getAllPeople",
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
  name: "people",
  initialState,
  extraReducers: (builder) => {
    builder.addCase(getAllPeople.pending, (state) => {
      state.isLoading = true;
    });
    builder.addCase(getAllPeople.fulfilled, (state, action) => {
      state.isLoading = false;
      state.peopleDetail = action.payload;
    });
    builder.addCase(getAllPeople.rejected, (state, action) => {
      state.isLoading = false;
      console.log(action);
    });
  },
});

export const { openModal, closeModal } = modalSlice.actions;
export default modalSlice.reducer;
