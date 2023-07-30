import { Form, Input, Modal } from "antd";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { closeModal, getAuthentication } from "../features/modal/modalSlice";
import { openSignUpModal } from "../features/modal/signUpSlice";

const LogInModal = () => {
  const { isOpen, isLoading } = useSelector((store) => store.modal);
  const dispatch = useDispatch();
  const [form] = Form.useForm();

  const closeModalContainer = () => {
    if (isLoading) {
      return;
    }
    form.resetFields();
    dispatch(closeModal());
  };
  const onSignUp = () => {
    closeModalContainer();
    dispatch(openSignUpModal());
  };

  const handleOk = async () => {
    if (isLoading) {
      return;
    }
    try {
      const values = await form.validateFields();
      console.log(values);
      dispatch(getAuthentication(values));
    } catch (errorInfo) {
      console.log("Validation Failed:", errorInfo);
    }
  };

  return (
    <Modal
      open={isOpen}
      okText="Log in"
      cancelText="Cancel"
      closeIcon={null}
      maskClosable={false}
      onCancel={closeModalContainer}
      onOk={handleOk}
      confirmLoading={isLoading}
    >
      <Form
        form={form}
        layout="horizontal"
        name="loginForm"
        initialValues={{ modifier: "public" }}
        labelCol={{
          span: 5,
        }}
      >
        <Form.Item
          label="Email"
          name="employeeId"
          rules={[
            {
              required: true,
              message: "Please input your username!",
            },
          ]}
        >
          <Input disabled={isLoading} />
        </Form.Item>

        {/* <Form.Item
          label="Password"
          name="password"
          rules={[
            {
              required: true,
              message: "Please input your password!",
            },
          ]}
        >
          <Input.Password disabled={isLoading} />
        </Form.Item> */}
        <p style={{ textAlign: "center" }}>
          <span>Don&apos;t have an account?</span>{" "}
          <Link to="/signup" onClick={onSignUp}>
            Sign Up
          </Link>
        </p>
      </Form>
    </Modal>
  );
};

export default LogInModal;
