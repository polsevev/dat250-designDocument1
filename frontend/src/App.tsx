import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import "./App.css";
import Poll from "./components/poll/Poll";
import Polls from "./components/polls/Polls";
import Main from "./Main";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Main />}>
      <Route path="/polls" element={<Polls />}></Route>
      <Route path="/poll/:id" element={<Poll />}></Route>
    </Route>
  )
);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
