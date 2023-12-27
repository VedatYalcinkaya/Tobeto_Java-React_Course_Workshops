import React from "react";
import { NavLink } from "react-router-dom";
import { Dropdown, DropdownDivider} from 'semantic-ui-react'

export default function CartSummary() {
  return (
    <div>
      <Dropdown item text="Sepetiniz">
        <Dropdown.Menu>
          <Dropdown.Item>Monster Notebook</Dropdown.Item>
          <Dropdown.Item>Xiaomi 13 Ultra</Dropdown.Item>
          <DropdownDivider/>
          <Dropdown.Item as={NavLink} to="/cart">Sepete Git</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    </div>
  );
}
