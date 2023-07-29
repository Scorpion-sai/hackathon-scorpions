import { useDispatch, useSelector } from "react-redux";
import PeopleDetail from "../components/PeopleDetail";
import { useEffect } from "react";
import { getPeople } from "../features/people/peopleSlice";
import PeopleSkeletonView from "../components/PeopleSkeletonView";
import { Row, Col, Spin } from "antd";
import { LoadingOutlined } from "@ant-design/icons";

const PeopleView = () => {
  const dispatch = useDispatch();
  const { peopleDetail, isLoading, error } = useSelector(
    (store) => store.people
  );
  useEffect(() => {
    if (!peopleDetail.length) {
      dispatch(getPeople());
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
  return (
    <Row gutter={[16, 16]}>
      {peopleDetail.map((person, index) => (
        <Col key={index} xs={24} sm={12} md={8} lg={6}>
          <PeopleDetail person={person} />
        </Col>
      ))}
    </Row>
  );
};

export default PeopleView;
