import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import LogInModal from "./pages/LogIn";
import { Row, Col } from "antd";

import SignUp from "./pages/SignUp";
import PageHeader from "./components/PageHeader";
import PersonalProfile from "./pages/PersonalProfile";
import PeopleView from "./pages/PeopleView";
import AddProjectForm from "./pages/AddProject";

const App = () => {
  return (
    <>
      <PageHeader />
      <Row justify="center" style={{ margin: "24px 0" }}>
        <Col xs={24} sm={24} md={22} lg={20} xl={20} xxl={18}>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/profile" element={<PersonalProfile />} />
            <Route path="/people" element={<PeopleView />} />
            <Route path="/signup" element={<SignUp />} />
          </Routes>
          <LogInModal />
          <SignUp />
          <AddProjectForm />
        </Col>
      </Row>
    </>
  );
};

export default App;
