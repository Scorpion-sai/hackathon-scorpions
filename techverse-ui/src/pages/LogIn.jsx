import { Form, Input, Modal } from "antd";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { closeModal, getAuthentication } from "../features/modal/modalSlice";

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

  const handleOk = async () => {
    if (isLoading) {
      return;
    }
    try {
      const values = await form.validateFields();
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
        name="form_in_modal"
        initialValues={{ modifier: "public" }}
        labelCol={{
          span: 5,
        }}
      >
        <Form.Item
          label="Email"
          name="username"
          rules={[
            {
              required: true,
              message: "Please input your username!",
            },
          ]}
        >
          <Input disabled={isLoading} />
        </Form.Item>

        <Form.Item
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
        </Form.Item>
        <p style={{ textAlign: "center" }}>
          <span>Don&apos;t have an account?</span>{" "}
          <Link to="/signup" onClick={closeModalContainer}>
            Sign Up
          </Link>
        </p>
      </Form>
    </Modal>
  );
};

export default LogInModal;

// import { Button, Checkbox, Form, Input } from "antd";
// import { styled } from "styled-components";
// const onFinish = (values) => {
//   console.log("Success:", values);
// };
// const onFinishFailed = (errorInfo) => {
//   console.log("Failed:", errorInfo);
// };

// const CenteredContainer = styled.div`
//   display: flex;
//   justify-content: center;
//   align-items: center;
//   height: 60vh;
// `;
// const FormContainer = styled.div`
//     background-color: white;
//     width: fit-content;
//     padding: 40px;
//     box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
// `;

// const LogIn = () => {
//   return (
//     <CenteredContainer>
//       <FormContainer>
//         <Form
//           name="basic"
//           labelCol={{
//             span: 8,
//           }}
//           wrapperCol={{
//             span: 24,
//           }}
//           initialValues={{
//             remember: true,
//           }}
//           onFinish={onFinish}
//           onFinishFailed={onFinishFailed}
//           autoComplete="off"
//         >
//           <Form.Item
//             label="Username"
//             name="username"
//             rules={[
//               {
//                 required: true,
//                 message: "Please input your username!",
//               },
//             ]}
//           >
//             <Input />
//           </Form.Item>

//           <Form.Item
//             label="Password"
//             name="password"
//             rules={[
//               {
//                 required: true,
//                 message: "Please input your password!",
//               },
//             ]}
//           >
//             <Input.Password />
//           </Form.Item>

//           <Form.Item
//             wrapperCol={{
//               offset: -10,
//               span: 240,
//             }}
//           >
//             <Button type="primary" htmlType="submit">
//               Submit
//             </Button>
//           </Form.Item>
//         </Form>
//       </FormContainer>
//     </CenteredContainer>
//   );
// };

// export default LogIn;
