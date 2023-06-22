//import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route} from 'react-router-dom';
import TicTacToe from './Pages/ticTacToe';
import TaskManagerHome from './Pages/taskManagerPages/taskManagerHome';

/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
*/

function App() {
  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path = "/" element = {<TicTacToe/>}/>
        <Route path = "/Home" element = {<TaskManagerHome/>}/>
      </Routes>    
    </BrowserRouter>
    </>
  );
}

export default App;
