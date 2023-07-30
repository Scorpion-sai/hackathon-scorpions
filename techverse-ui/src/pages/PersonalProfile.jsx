import { Avatar, Col, Row, Typography, Spin, Badge } from "antd";
import { UserOutlined } from "@ant-design/icons"; // Import the built-in UserOutlined icon
import { useDispatch, useSelector } from "react-redux";
import { getAllPeople } from "../features/people/peopleSlice";
import { useEffect } from "react";
import { styled } from "styled-components";

const { Title, Text } = Typography;

const BadgeContainer = styled.div`
    display: flex;
    gap: 4px;
    margin: 8px 0;
    flex-wrap: wrap;
`;

const PersonalProfile = () => {
  const dispatch = useDispatch();
  // Sample data (replace with actual data)
  const { peopleDetail, isLoading, error } = useSelector(
    (store) => store.people
  );
  const { employeeId } = useSelector((store) => store.modal);
  useEffect(() => {
    if (!peopleDetail.length) {
      dispatch(getAllPeople());
    }
  }, []);

  if (isLoading) {
    return (
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
          height: "60vh",
        }}
      >
        <Spin
          size="large"
          // indicator={<LoadingOutlined style={{ fontSize: 24 }} spin />}
        />
      </div>
    );
  }

  // const profileData = {
  //   name: "John Doe",
  //   employeeId: "E12345",
  //   email: "john.doe@example.com",
  //   gender: "Male",
  //   designation: "Software Engineer",
  //   yearsOfExperience: 5,
  //   techStack: ["React", "Node.js", "MongoDB"],
  //   areaOfInterest: "Machine Learning",
  //   projectData: [
  //     {
  //       projectName: "E-commerce Website",
  //       description: "Developed an e-commerce website using React and Node.js.",
  //       rolesResponsibility: "Frontend development, API integration.",
  //       achievements: "Increased user engagement by 30%.",
  //       techUsed: ["React", "Node.js", "Express", "MongoDB"],
  //       duration: "July 2020 - September 2021",
  //     },
  //   ],
  // };
  const profileData = peopleDetail.find(
    (people) => people.emailId === employeeId
  );
  console.log(peopleDetail, profileData);

  return (
    <>
      <Row>
        <Col style={{ textAlign: "center", marginBottom: 20 }}>
          <Avatar
            style={{
              backgroundColor: "orange",
              verticalAlign: "middle",
              alignItems: "center",
              height: "200px",
              width: "200px",
              display: "flex", // Add display: flex to center the custom icon
              justifyContent: "center", // Add justifyContent: center to center the custom icon
            }}
            size={200} // Set the size to match the height and width
            icon={
              <UserOutlined style={{ fontSize: "150px", color: "white" }} />
            } // Use the custom SVG icon as the placeholder
          ></Avatar>
          <Title level={3}>{profileData?.name}</Title>
          <Text strong>{profileData?.designation}</Text>
        </Col>

        <Col style={{ textAlign: "left", maxWidth: 600, margin: "0 auto" }}>
          <Title level={4}>Employee Details</Title>
          <Text>
            <strong>Employee ID:</strong> {profileData?.currentDesignation}
          </Text>
          <br />
          <Text>
            <strong>Email:</strong> {profileData?.emailId}
          </Text>
          <br />
          {/* <Text>
            <strong>Gender:</strong> {profileData.gender}
          </Text> */}
          <br />
          <Text>
            <strong>Years of Experience:</strong>{" "}
            {profileData?.yearsOfExperience}
          </Text>
          <br />
          <Text>
            <strong>Tools/Tech/Database/Framework:</strong>{" "}
            <BadgeContainer>
              {profileData?.skills.map((tech) => (
                <Badge count={tech} color={techColorMap[tech.toLowerCase()]} />
              ))}
            </BadgeContainer>
          </Text>
          <br />
          <Text>
            <strong>Area of Interest:</strong> {profileData?.areaOfInterest}
          </Text>
          <br />

          {/* <Title level={4}>Project Details</Title>
          {profileData.projectData.map((project, index) => (
            <div key={index}>
              <Text>
                <strong>Project Name:</strong> {project.projectName}
              </Text>
              <br />
              <Text>
                <strong>Description:</strong> {project.description}
              </Text>
              <br />
              <Text>
                <strong>Roles & Responsibilities:</strong>{" "}
                {project.rolesResponsibility}
              </Text>
              <br />
              <Text>
                <strong>Achievements:</strong> {project.achievements}
              </Text>
              <br />
              <Text>
                <strong>Tools/Tech/Database/Framework:</strong>{" "}
                {project.techUsed.join(", ")}
              </Text>
              <br />
              <Text>
                <strong>Duration:</strong> {project.duration}
              </Text>
              <br />
              <br />
            </div>
          ))} */}
        </Col>
      </Row>
    </>
  );
};

export default PersonalProfile;
