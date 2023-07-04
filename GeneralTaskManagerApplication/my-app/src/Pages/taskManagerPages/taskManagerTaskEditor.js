import SideBar from "../../Components/taskManagerComponents/SideBar";
import Cookies from "js-cookie";

export default function TaskManagerEditor(){

    let NumTasks = (listCookies());
    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate()+1);
    
        function SetCookie(){
            Cookies.set(NumTasks.toString(),"hello " + NumTasks, {expires: tomorrow})
            NumTasks++;
        }

        function listCookies() {
            var theCookies = document.cookie.split(';');
            /*
            var aString = ''; // used if I want to list out all cookies but for now only need num cookies
            
            for (var i = 1 ; i <= theCookies.length; i++) {
                aString += i + ' ' + theCookies[i-1] + "\n";
            }
            */
            return theCookies.length;
        }

    let cookieHolder = listCookies();
    
    
    
        function GetCookie(){
             alert(Cookies.get((NumTasks-1).toString()));
        }
    
    
        function RemoveCookie(){
            Cookies.remove((NumTasks-1).toString());
            if(NumTasks > 0){
                NumTasks--;
            }
            else{
                alert("No More Cookies");
            }
            
        }
    

    return(
        <div>
            <style>
                {`
                    #editorTitle{
                        font-size: 70pt;
                        text-align: center;
                    }

                    #editorBody{
                        width: 85%;
                        float: right;

                    }

                    .button{
                        width: 30%;
                        font-size: 20pt;
                    }
                
                
                `}
            </style>           
             
             <SideBar/>
             <div id = "editorBody">
                <h1 id = "editorTitle">
                        Manage Tasks
                </h1>
                <div class = "button">
                        <button id = "newTaskButton" onClick={SetCookie}> New Cookie: {cookieHolder - 1}</button>
                </div>
                <div class = "button">
                        <button id = "getCookie" onClick={GetCookie}> Get Cookie: {NumTasks - 1}</button>
                </div>
                <div class = "button">
                        <button id = "removeCookie" onClick={RemoveCookie}> Remove Cookie</button>
                </div>
             </div>
             
        </div>
    );


}