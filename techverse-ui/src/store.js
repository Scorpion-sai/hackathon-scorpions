import { configureStore } from "@reduxjs/toolkit";
import modalReducer from "./features/modal/modalSlice";
import peopleReducer from "./features/people/peopleSlice";

export const store = configureStore({
  reducer: {
    modal: modalReducer,
    people: peopleReducer,
  },
});
