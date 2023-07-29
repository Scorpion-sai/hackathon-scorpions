import { styled } from "styled-components";
import SearchBar from "./Searchbar";
import { Button } from "antd";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { openModal } from "../features/modal/modalSlice";
import { UserCircle } from "../assets/Icons";

const HeaderContainer = styled.div`
    height: 60px;
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
  const { profile } = useSelector((store) => store.modal);

  return (
    <HeaderContainer>
      <div>
        <Link to="/">TechVerse</Link>
      </div>
      <SearchBar />
      <div>People</div>
      <div>Projects</div>
      <div>Technologies</div>
      <LoginCorner>
        {!profile.name ? (
          <Link to="/profile">
            <div style={{ display: "flex" }}>
              <UserCircle />
              Profile
            </div>
          </Link>
        ) : (
          <>
            <Button onClick={() => dispatch(openModal())}>Log in</Button>
            <Button type="primary">Sign up</Button>
          </>
        )}
      </LoginCorner>
    </HeaderContainer>
  );
};

export default PageHeader;
