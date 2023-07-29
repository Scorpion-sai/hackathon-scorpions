import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import LogInModal from "./pages/LogIn";

// import SignUp from "./pages/SignUp";
import PageHeader from "./components/PageHeader";
import PersonalProfile from "./pages/PersonalProfile";

const App = () => {
  return (
    <>
      <PageHeader />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/profile" element={<PersonalProfile />} />
        {/* <Route path="/signup" element={<SignUp />} /> */}
      </Routes>
      <LogInModal />
    </>
  );
};

export default App;
