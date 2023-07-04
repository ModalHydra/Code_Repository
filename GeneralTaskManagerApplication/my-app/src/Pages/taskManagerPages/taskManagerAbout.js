import SideBar from "../../Components/taskManagerComponents/SideBar";

export default function TaskManagerAbout(){

    return(
        <div>
            <style>
                {`
                    #aboutTitle{
                        
                        font-size: 70pt;
                        text-align: center;
                    }

                    #aboutBody{
                        width: 85%;
                        float: right;
                    }

                    #aboutText{
                        text-align: center;
                        font-size: 16pt;
                    }
                
                
                `}
            </style>
           
             
             <SideBar/>
             <div id = "aboutBody">
                <h1 id = "aboutTitle">
                        About
                </h1>

                <p id = "aboutText">
                        
                        
                            I am Gabriel Bentley and I created the General Task Manager as a personal project.<br></br>
                            <br></br>
                            <br></br>
                            <br></br>
                            The General Task Manager is used to keep track of tasks that might <br></br>
                            not have a specific due date or need to be repeated over a given period of time. <br></br>
                            <br></br>
                            <br></br>
                            <br></br>
                            On the Home page you can view, confirm, skip, or delete any task you have. <br></br>
                            In the Manage Tasks section you can create a new task or edit an existing task. <br></br>
                            The Overdue Tasks section shows only the tasks you have given a due date that have not been completed on time.<br></br>
                            The Calendar view is an alternative way to view what tasks you have set and when they are due.
                        
                </p>
             </div>
             
        </div>
    );


}