import { Space, Select, Input } from "antd";
import { SearchOutlined } from "@ant-design/icons";

const SearchBar = () => {
  const options = [
    {
      value: "all",
      label: "All",
    },
    {
      value: "people",
      label: "People",
    },
    {
      value: "projects",
      label: "Projects",
    },
  ];

  return (
    <Space>
      <Space.Compact>
        <Input
          placeholder="Search"
          addonBefore={<SearchOutlined />}
          style={{ width: "400px" }}
        />
        <Select
          defaultValue="All"
          options={options}
          style={{ height: "100%", width: "auto" }}
          dropdownStyle={{ minWidth: "100px" }}
        />
      </Space.Compact>
    </Space>
  );
};

export default SearchBar;
