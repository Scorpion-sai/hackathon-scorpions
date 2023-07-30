import { styled } from "styled-components";
import SearchBar from "./Searchbar";
import { Button, Dropdown } from "antd";
import { Link, useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { openModal, logout } from "../features/modal/modalSlice";
import { openSignUpModal } from "../features/modal/signUpSlice";
import { openModal as openAddProjectModal } from "../features/modal/addProjectSlice";
import { UserCircle } from "../assets/Icons";

const HeaderContainer = styled.nav`
    height: 60px;
    background-color: white;
    z-index: 10;
    position: sticky;
    top: 0;
    border-bottom: 2px solid gray;
    display: flex;
    align-items: center;
    padding: 4px 56px;
    gap: 8px;
`;

const LoginCorner = styled.div`
    display: flex;
    gap: 8px;
    margin-left: auto;
`;

const PageHeader = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const {
    profile: { employeeId: mailId },
  } = useSelector((store) => store.modal);
  const {
    profile: { employeeId },
  } = useSelector((store) => store.signUp);
  const isSignedIn = mailId || employeeId;

  const items = [
    {
      label: (
        <Link onClick={() => dispatch(openAddProjectModal())}>
          Add Projects
        </Link>
      ),
      key: "0",
    },
    {
      label: (
        <Link
          to="/"
          onClick={() => {
            navigate("/");
            dispatch(logout());
          }}
        >
          Logout
        </Link>
      ),
      key: "1",
    },
  ];

  return (
    <HeaderContainer>
      <div>
        <Link to="/">
          <img
            src="../../public/techverse.png"
            alt="logo"
            height="30"
            width="30"
          />
        </Link>
      </div>
      {isSignedIn && (
        <>
          <SearchBar />
          <div>
            <Link to="/people">People</Link>
          </div>
          {/* <div>Projects</div>
          <div>Technologies</div> */}
        </>
      )}
      <LoginCorner>
        {isSignedIn ? (
          <Dropdown menu={{ items }}>
            <Link to="/profile">
              <div style={{ display: "flex" }}>
                <UserCircle />
                Profile
              </div>
            </Link>
          </Dropdown>
        ) : (
          <>
            <Button onClick={() => dispatch(openModal())}>Log in</Button>
            <Button type="primary" onClick={() => dispatch(openSignUpModal())}>
              Sign up
            </Button>
          </>
        )}
      </LoginCorner>
    </HeaderContainer>
  );
};

export default PageHeader;
