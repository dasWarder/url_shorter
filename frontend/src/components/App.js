import './App.css';
import ConvertUrl from "./ConvertUrl";

function App() {
  return (
    <div className='Main-container'>
        <h1 style={ { textAlign: 'center', fontSize: '3em', fontFamily: 'Comic Sans MS'} }>URL shorter</h1>
        <ConvertUrl />
    </div>
  );
}

export default App;
