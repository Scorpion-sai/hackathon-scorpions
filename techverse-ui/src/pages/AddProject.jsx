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
import React from "react";
import { styled } from "styled-components";
import { useDispatch, useSelector } from "react-redux";
import { closeModal, addProject } from "../features/modal/addProjectSlice";

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
  /* padding-right: 16px;  */
}`;

const AddProjectForm = () => {
  const { isOpen, isLoading } = useSelector((store) => store.project) || {};
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
      console.log(values);
      dispatch(addProject(values));
    } catch (errorInfo) {
      console.log("Validation Failed:", errorInfo);
    }
  };

  return (
    <StyledModal
      open={isOpen}
      okText="Add Project"
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
        name="addProjectForm"
        initialValues={{ modifier: "public" }}
      >
        <Form.Item
          label="Project Name"
          name="projectName"
          rules={[
            {
              required: true,
              message: "Please input your Project Name!",
            },
          ]}
        >
          <Input />
        </Form.Item>
        <Form.Item
          label="Project Details"
          name="projectDescription"
          rules={[
            {
              required: true,
              message: "Please input your Project Name!",
            },
          ]}
        >
          <Input.TextArea rows={3} placeholder="Project Details" />
        </Form.Item>
        <Form.Item label="Responsibility" name="responsibility">
          <Input />
        </Form.Item>
        <Form.Item label="Achievements" name="achievements">
          <Input.TextArea rows={2} placeholder="Project Details" />
        </Form.Item>
        <Space style={{ display: "flex" }} align="start">
          <Form.Item label="From" name="from" style={{ flex: 1 }}>
            <DatePicker />
          </Form.Item>
          <Form.Item label="To" name="to" style={{ flex: 1 }}>
            <DatePicker />
          </Form.Item>
        </Space>

        <Form.Item label="Skills Used" name="skillsUsed">
          <Select
            mode="tags"
            style={{ width: "100%" }}
            placeholder="Select or enter technologies"
            options={options}
          />
        </Form.Item>
      </Form>
    </StyledModal>
  );
};

export default AddProjectForm;
