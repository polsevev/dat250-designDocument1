import "./Header.css";
const Header = () => {
  return (
    <div className="header">
      <h1 className="header-title">Mercury Polls</h1>
      <a href="/logout" className="logout_button">
        Logout
      </a>
    </div>
  );
};

export default Header;
