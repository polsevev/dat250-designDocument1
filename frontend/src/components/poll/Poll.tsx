import { ReactElement, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import "./Poll.css";

const questions = [
  "Pølsefest?",
  "Stemmer du rødt?",
  "Hvem er Dan Tony?",
  "Skal du vaske i dag?",
];

const Poll = (): ReactElement => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [currentQuestionNumber, setCurrentQuestionNumber] = useState(0);
  const [answers, setAnswers] = useState<boolean[]>([]);

  if (!id) {
    navigate("/");
  }

  const handleAnswer = (answer: "yes" | "no") => {
    if (currentQuestionNumber + 1 > questions.length) {
    }
    setCurrentQuestionNumber(currentQuestionNumber + 1);
    setAnswers([...answers, answer === "yes"]);
  };

  return (
    <div className="container question-container">
      {currentQuestionNumber < questions.length ? (
        <>
          <div className="question-item-container">
            <h4 className="question-sub-header">
              Question {currentQuestionNumber + 1}/{questions.length}
            </h4>
          </div>
          <div className="question-item-container">
            <h3 className="question-title">
              {questions[currentQuestionNumber]}
            </h3>
          </div>
          <div className="question-answers question-item-container">
            <button
              className="answer-button"
              onClick={() => handleAnswer("yes")}
            >
              YES
            </button>
            <button
              className="answer-button"
              onClick={() => handleAnswer("no")}
            >
              NO
            </button>
          </div>
        </>
      ) : (
        <div className="question-item-container">
          <div className="done-container">
            <h3 className="question-title">DONE</h3>
            <Link to="/">home</Link>
          </div>
        </div>
      )}
    </div>
  );
};

export default Poll;
