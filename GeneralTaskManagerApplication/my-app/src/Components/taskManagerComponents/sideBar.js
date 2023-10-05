import { useNavigate } from "react-router-dom";
import {useState} from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import {IconContext} from "react-icons";
import "../../Styles/taskManagerStyles/sidebar.css";

var od = 0;




export default function SideBar(){

    const [active, setActive] = useState(true);

    function closeSideBar(){
        setActive(!active);
    }

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
        <div id = "sideWrapper">
        <p id = "closeButtonBody">
            <button id = "closeSideBarButton" onClick = {() => closeSideBar()} >
                X
            </button>
        </p>

        <div id = {active ? "sideBarBody" : "sideBarBodyClosed"}>
            
            <ul className="sideBarList">
                <li>
                    <p id = "sideBarHeader">
                        General Task Manager
                    </p>
                </li>
                <li className="sideBarButton">
                    <button id = "homeButton" onClick = {goHome}>
                        Home
                    </button>
                </li>
                <li className="sideBarButton">
                    <button id = "manageButton" onClick = {goManage}>
                        Manage Tasks
                    </button>
                </li>
                <li className="sideBarButton">
                    <button id = "overdueButton" onClick = {goOverdue}>
                        Overdue Tasks
                    </button>
                </li>
                <li className="sideBarButton">
                    <button id = "calendarButton" onClick = {goCalendar}>
                        Calendar View
                    </button>
                </li>
                <li className="sideBarButton">
                    <button id = "aboutButton" onClick = {goAbout}>
                        About
                    </button>
                </li>
                <div className = "overdueTaskCounter">
                    You have {od} overdue tasks 
                </div>
            </ul>
        </div>
        
        
        
        </div>
        
    );
}