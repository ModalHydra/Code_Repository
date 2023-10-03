import Game from "../Components/ticTacComponents/Game";
import "../Styles/ticTacToe.css";

export default function ticTacToe(){
    return(
        <div>
            <h1>Time to play Tic Tac Toe</h1>
            <Game />
        </div>
    );
}