import "./App.css";
import Header from "./components/Header";
import Polls from "./components/polls/Polls";

function App() {
  return (
    <div>
      <Header />
      <div className="container">
        <Polls />
      </div>
    </div>
  );
}

export default App;
