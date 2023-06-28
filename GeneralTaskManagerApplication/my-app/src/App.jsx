//import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route} from 'react-router-dom';
import TicTacToe from './Pages/ticTacToe';
import TaskManagerHome from './Pages/taskManagerPages/taskManagerHome';
import TaskManagerAbout from './Pages/taskManagerPages/taskManagerAbout';
import TaskManagerCalendar from './Pages/taskManagerPages/taskManagerCalendar';
import TaskManagerOverdue from './Pages/taskManagerPages/taskManagerOverdue';
import TaskManagerEditor from './Pages/taskManagerPages/taskManagerTaskEditor';

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
        <Route path = "/About" element = {<TaskManagerAbout/>}/>
        <Route path = "/Calendar" element = {<TaskManagerCalendar/>}/>
        <Route path = "/Editor" element = {<TaskManagerEditor/>}/>
        <Route path = "/Overdue" element = {<TaskManagerOverdue/>}/>
      </Routes>    
    </BrowserRouter>
    </>
  );
}

export default App;
