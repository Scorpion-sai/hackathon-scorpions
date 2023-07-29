import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

const url = "https://course-api.com/react-useReducer-cart-project";

const initialState = {
  isLoading: false,
  peopleDetail: [
    {
      id: "1",
      name: "John",
      job: "Senior Architect",
      email: "john@gmail.com",
      mobile: "123456",
      technologies: ["Java", "Kafka"],
      experience: "5",
    },
    {
      id: "1",
      name: "John",
      job: "Senior Architect",
      email: "john@gmail.com",
      mobile: "123456",
      technologies: ["JavaScript", "Node"],
    },
    {
      id: "1",
      name: "John",
      job: "Senior Architect",
      email: "john@gmail.com",
      mobile: "123456",
      technologies: ["JavaScript", "Node"],
    },
    {
      id: "1",
      name: "John",
      job: "Senior Architect",
      email: "john@gmail.com",
      mobile: "123456",
      technologies: ["JavaScript", "Node"],
    },
    {
      id: "1",
      name: "John",
      job: "Senior Architect",
      email: "john@gmail.com",
      mobile: "123456",
      technologies: ["JavaScript", "Node"],
    },
  ],
};

export const getPeople = createAsyncThunk(
  "people/getPeople",
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
    builder.addCase(getPeople.pending, (state) => {
      state.isLoading = true;
    });
    builder.addCase(getPeople.fulfilled, (state, action) => {
      state.isLoading = false;
      // TODO: uncomment
      //   state.peopleDetail = action.payload;
    });
    builder.addCase(getPeople.rejected, (state, action) => {
      state.isLoading = false;
      console.log(action);
    });
  },
});

export const { openModal, closeModal } = modalSlice.actions;
export default modalSlice.reducer;
