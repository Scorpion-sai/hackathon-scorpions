import { configureStore } from "@reduxjs/toolkit";
import modalReducer from "./features/modal/modalSlice";
import signUpReducer from "./features/modal/signUpSlice";
import peopleReducer from "./features/people/peopleSlice";

export const store = configureStore({
  reducer: {
    modal: modalReducer,
    signUp: signUpReducer,
    people: peopleReducer,
  },
});
