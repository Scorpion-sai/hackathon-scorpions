import {
  Form,
  Input,
  InputNumber,
  DatePicker,
  Select,
  Button,
  Space,
  Modal,
} from "antd";
import { PlusOutlined, MinusCircleOutlined } from "@ant-design/icons";
import React from "react";
import { styled } from "styled-components";
import { useDispatch, useSelector } from "react-redux";
import { closeSignUpModal, registerUser } from "../features/modal/signUpSlice";

const options = [
  {
    value: "python",
    label: "Python",
  },
  {
    value: "javascript",
    label: "Javascript",
  },
  {
    value: "java",
    label: "Java",
  },
  {
    value: "angular",
    label: "Angular",
  },
  {
    value: "nodejs",
    label: "NodeJs",
  },
  {
    value: "react",
    label: "React",
  },
  {
    value: "vue",
    label: "Vue",
  },
  {
    value: "aws",
    label: "AWS",
  },
  {
    value: "kafka",
    label: "Kafka",
  },
];

const StyledModal = styled(Modal)`
.ant-modal-body {
  /* max-height: 400px;
  overflow-y: auto; */
  padding-right: 16px; 
}`;

const SignUpForm = () => {
  const { isOpen, isLoading } = useSelector((store) => store.signUp);
  const dispatch = useDispatch();
  const [form] = Form.useForm();

  const closeModalContainer = () => {
    if (isLoading) {
      return;
    }
    form.resetFields();
    dispatch(closeSignUpModal());
  };

  const handleOk = async () => {
    if (isLoading) {
      return;
    }
    try {
      const values = await form.validateFields();
      console.log(values);
      dispatch(registerUser(values));
    } catch (errorInfo) {
      console.log("Validation Failed:", errorInfo);
    }
  };

  return (
    <StyledModal
      open={isOpen}
      okText="Sign up"
      cancelText="Cancel"
      closeIcon={null}
      maskClosable={false}
      onCancel={closeModalContainer}
      onOk={handleOk}
      confirmLoading={isLoading}
    >
      <Form
        form={form}
        layout="vertical"
        name="signupForm"
        initialValues={{ modifier: "public" }}
      >
        <Form.Item
          label="Name"
          name="name"
          rules={[
            {
              required: true,
              message: "Please input your Name!",
            },
          ]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          label="Email"
          name="emailId"
          rules={[
            { required: true, message: "Please enter your email address" },
            { type: "email", message: "Please enter a valid email address" },
          ]}
        >
          <Input />
        </Form.Item>
        <Space style={{ display: "flex" }} align="start">
          <Form.Item
            label="Date of Birth"
            name="dob"
            rules={[
              { required: true, message: "Please select your date of birth" },
            ]}
            style={{ flex: 1 }}
          >
            <DatePicker />
          </Form.Item>
          <Form.Item
            label={
              <span
                style={{
                  whiteSpace: "normal",
                  width: "100%",
                  display: "inline-block",
                }}
              >
                Experience (in Years)
              </span>
            }
            name="yearsOfExperience"
            style={{ width: "175%" }}
          >
            <InputNumber min={0} style={{ width: "100%" }} />
          </Form.Item>
        </Space>

        <Form.Item
          label="Job Role"
          name="currentDesignation"
          rules={[
            {
              required: true,
              message: "Please enter your current designation",
            },
          ]}
        >
          <Input />
        </Form.Item>

        <Form.Item label="Technologies" name="skills">
          <Select
            mode="tags"
            style={{ width: "100%" }}
            placeholder="Select or enter technologies"
            options={options}
          />
        </Form.Item>

        <Form.Item
          label="Area of Interest"
          name="areaOfInterest"
          rules={[
            {
              required: true,
              message: "Please enter your area of interest",
            },
          ]}
        >
          <Input />
        </Form.Item>

        {/* <Form.Item label="Projects">
          <Form.List name="projects">
            {(fields, { add, remove }) => (
              <>
                {fields.map((field) => (
                  <Space
                    key={field.key}
                    style={{ display: "flex", marginBottom: 8 }}
                    align="start"
                  >
                    <Form.Item
                      {...field}
                      name={[field.name, "name"]}
                      rules={[
                        {
                          required: true,
                          message: "Please enter project name",
                        },
                      ]}
                    >
                      <Input placeholder="Project Name" />
                    </Form.Item>

                    <Form.Item {...field} name={[field.name, "details"]}>
                      <Input.TextArea rows={2} placeholder="Project Details" />
                    </Form.Item>

                    {fields.length > 1 ? (
                      <MinusCircleOutlined onClick={() => remove(field.name)} />
                    ) : null}
                  </Space>
                ))}

                <Form.Item>
                  <Button
                    type="dashed"
                    onClick={() => add()}
                    block
                    icon={<PlusOutlined />}
                  >
                    Add Project
                  </Button>
                </Form.Item>
              </>
            )}
          </Form.List>
        </Form.Item> */}
      </Form>
    </StyledModal>
  );
};

export default SignUpForm;
