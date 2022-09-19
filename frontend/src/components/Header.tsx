import { Link } from "react-router-dom";
import "./Header.css";
const Header = () => {
  return (
    <div className="header">
      <h1 className="header-title">
        <Link to="/">Mercury Polls</Link>
      </h1>
      <a href="/logout" className="logout_button">
        Logout
      </a>
    </div>
  );
};

export default Header;
