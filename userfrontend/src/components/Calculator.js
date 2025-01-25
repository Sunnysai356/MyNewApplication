import React, { useState } from 'react';
import axios from 'axios';

function Calculator() {
    const [value1, setValue1] = useState(0);
    const [value2, setValue2] = useState(0);
    const [result, setResult] = useState(null);

    const handleOperation = async (operation) => {
        try {
            const response = await axios.post('http://localhost:8088/api/calculate/calculator', { value1, value2, operation });
            console.log(response.data);
            setResult(response.data);
        } catch (error) {
            alert('Error performing operation');
        }
    };

    return (
        <div>
            <h2>Calculator</h2>
            <input type="number" value={value1} onChange={(e) => setValue1(+e.target.value)} />
            <input type="number" value={value2} onChange={(e) => setValue2(+e.target.value)} />
            <div>
                <button onClick={() => handleOperation('add')}>Add</button>
                <button onClick={() => handleOperation('subtract')}>Subtract</button>
                <button onClick={() => handleOperation('multiply')}>Multiply</button>
                <button onClick={() => handleOperation('divide')}>Divide</button>
            </div>
            {result !== null && <h3>Result: {result}</h3>}
        </div>
    );
}

export default Calculator;
