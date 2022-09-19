import "./Polls.css";

const polls = [
  { question: "Do you like rust?" },
  { question: "Ananas on pizza?" },
  { question: "Big?" },
];

const Polls = () => {
  return (
    <div className="container">
      <ul className="polls-list">
        {polls.map((poll, i) => (
          <li key={i}>
            <div className="poll-item">{poll.question}</div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Polls;
