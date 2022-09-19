import { Link, Outlet, useMatch } from "react-router-dom";
import Header from "./components/Header";

const Main = () => {
  const matchPollRoute = useMatch("/poll/:id");
  const matchRootRoute = useMatch("/");
  return (
    <div>
      {!matchPollRoute && <Header />}
      {matchRootRoute && (
        <div>
          yoo <Link to="/polls">my polls</Link>
        </div>
      )}
      <Outlet />
    </div>
  );
};

export default Main;
