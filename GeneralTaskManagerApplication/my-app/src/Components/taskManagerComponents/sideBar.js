import { useNavigate } from "react-router-dom";

var od = 0;
export default function SideBar(){

    let navigate = useNavigate();

    const goHome = () =>{
        let path = '/Home';
        navigate(path);

    }

    const goOverdue = () =>{
        let path = '/Overdue';
        navigate(path);

    }

    const goCalendar = () =>{
        let path = '/Calendar';
        navigate(path);

    }

    const goAbout = () =>{
        let path = '/About';
        navigate(path);

    }

    const goManage = () =>{
        let path = '/Editor';
        navigate(path);

    }


    return(
        <>

        <style>
            {`
                #sideBarBody {
                    background: #FF8484;
                    width: 15%;
                    height: 100vh;
                    text-align: center;
                    position: fixed;
                    border: solid 2px;
                }

                button {
                    background: #FFBCBC;
                    width: 65%;
                    height: 3em;
                    margin: 1em;
                    button-radius: 12px;
                    transition-duration: 0.4s;

                }
                button:hover {
                    background-color: #FFACAC; /* Green */
                    //color: white;
                  }

                #sideBarHeader {
                    text-shadow: 1px 1px 1px red;
                    font-size: 24pt;
                }

                #overdueTaskCounter {
                    //color: white;
                    position: relative;
                    top: 50px;
                    font-size: 18pt;
                    background: #FF5C5C;
                    width: 80%;
                    margin: auto;
                    border: solid 2px;
                }
            `}
        </style>

        <div id = "sideBarBody">
            <p id = "sideBarHeader">
                General Task Manager
            </p>
            <button id = "homeButton" onClick = {goHome}>
                Home
            </button>
            <button id = "manageButton" onClick = {goManage}>
                Manage Tasks
            </button>
            <button id = "overdueButton" onClick = {goOverdue}>
                Overdue Tasks
            </button>
            <button id = "calendarButton" onClick = {goCalendar}>
                Calendar View
            </button>
            <button id = "aboutButton" onClick = {goAbout}>
                About
            </button>

            <div id = "overdueTaskCounter">
                You have {od} overdue tasks 
            </div>
        </div>
        
        
        
        </>
        
    );
}