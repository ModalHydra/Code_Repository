  import Square from "./square.js";
  
  export default function Board({xTurn, squares, onPlay}) {
    
  
    function handleClick(i){
  
      if(squares[i] || calculateWinner(squares)){
        return;
      }
  
      const nextSquares = squares.slice();
      if(xTurn){
        nextSquares[i] = 'X';
      }
      else{
        nextSquares[i] = 'O';
      }
      onPlay(nextSquares);
    }
  
  
    const winner = calculateWinner(squares);
    let gameText;
  
    if(winner){
      gameText = "Winner: " + winner;
    }
    else{
      gameText = "Next player: " + (xTurn ? 'X' : 'O');
    }
  
    return(
          <div>
          <div className='status'>{gameText}</div>
          <div className="board-row">
            <Square value = {squares[0]} onSquareClicked={() => handleClick(0)}/>
            <Square value = {squares[1]} onSquareClicked={() => handleClick(1)}/>
            <Square value = {squares[2]} onSquareClicked={() => handleClick(2)}/>
          </div>
          <div className="board-row">
            <Square value = {squares[3]} onSquareClicked={() => handleClick(3)}/>
            <Square value = {squares[4]} onSquareClicked={() => handleClick(4)}/>
            <Square value = {squares[5]} onSquareClicked={() => handleClick(5)}/>
          </div>
          <div className="board-row">
            <Square value = {squares[6]} onSquareClicked={() => handleClick(6)}/>
            <Square value = {squares[7]} onSquareClicked={() => handleClick(7)}/>
            <Square value = {squares[8]} onSquareClicked={() => handleClick(8)}/>
          </div>
          </div>
          );
  }


  function calculateWinner(squares){
    const lines = [
      [0, 1, 2],
      [3, 4, 5],
      [6, 7, 8],
      [0, 3, 6],
      [1, 4, 7],
      [2, 5, 8],
      [0, 4, 8],
      [2, 4, 6]
    ];
  
    for(let i = 0; i < lines.length; i++){
      const temp = lines[i];
      if(squares[temp[0]] && squares[temp[0]] === squares[temp[1]] && squares[temp[0]] === squares[temp[2]]){
        return squares[temp[0]];
      }
    }
  
    return null;
  }