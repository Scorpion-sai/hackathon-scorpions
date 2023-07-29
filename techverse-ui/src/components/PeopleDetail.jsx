import React from "react";
import { Card, Avatar, Badge } from "antd";
import { styled } from "styled-components";

const StyledCard = styled(Card)`
  transition: box-shadow 0.2s, background-color 0.2s;
  cursor: pointer;

  &:hover {
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
    background-color: #f8f8f8;
  }
`;

const NameContainer = styled.h4`
    max-width: 100%;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
`;

const FirstLetter = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 64px;
  height: 64px;
  font-size: 32px;
  border-radius: 50%;
  background-color: transparent;
  font-weight: 500;
  color: #fff;
`;

const BadgeContainer = styled.div`
    display: flex;
    gap: 4px;
    margin: 8px 0;
    flex-wrap: wrap;
`;

const CardBody = styled.ul`
    display: flex;
    flex-direction: column;
    gap: 8px;
`;

const PeopleDetail = ({ person }) => {
  const initial = person.name[0];
  const techColorMap = {
    javascript: "#ecd300",
    java: "#ec272b",
    python: "#2962ff",
    node: "#94c745",
  };

  return (
    <StyledCard
      style={{
        marginBottom: 16,
        boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
        height: "300px",
      }}
      cover={
        <div style={{ display: "flex" }}>
          <div style={{ padding: 16 }}>
            <Avatar size={64} src={person.profilePicture}>
              <FirstLetter>
                {!person.profilePicture && person.name[0].toUpperCase()}
              </FirstLetter>
            </Avatar>
          </div>
          <div style={{ overflow: "hidden", padding: "16px 16px 16px 0px" }}>
            <NameContainer>{person.name}</NameContainer>
            <p>{person.emailId}</p>
          </div>
        </div>
      }
    >
      <Card.Meta
        description={
          <CardBody>
            <BadgeContainer>
              {person.skills.map((tech) => (
                <Badge count={tech} color={techColorMap[tech.toLowerCase()]} />
              ))}
            </BadgeContainer>
            <li>Job Role: {person.currentDesignation}</li>
            {person.yearsOfExperience != null &&
              person.yearsOfExperience > 0 && (
                <li>Experience: {person.yearsOfExperience} years</li>
              )}
            {person.areaOfInterest && (
              <li>Interests: {person.areaOfInterest} years</li>
            )}
          </CardBody>
        }
      />
    </StyledCard>
  );
};

export default PeopleDetail;
