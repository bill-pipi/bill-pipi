/**function MyButton({num}){
  return (
    <button> Hello World {num}</button>
  );
}
**/

import { useState } from "react";


function MyButton({num}){

  const [count, setCount] = useState(0);

  function handleClick() {
    setCount(count + 1);
  }



  return (
    <button onClick={handleClick}> 
      Hello World {num} {count}</button>
  );

}

function App() {
  let bts = ["A", "b", "C"]
  return (
    <div>
      {
        bts.map( 
          (bt) => <MyButton num={bt}/> 
        )
      }
      
    </div>
  )

}

export default App
