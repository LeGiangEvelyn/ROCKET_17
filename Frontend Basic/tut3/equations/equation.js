function linearEquation(a,b){
if (a==0){
    if (b==0){
        return 'Many root!!';
    } else {
        return 'No root!!';
    }} else {
       return 'One root: ' + -b/a;
    }
}

function quadraticEquation(a,b,c){
    if (a===0){
        return linearEquation(b,c);
    } else {
        const delta = b*b - 4*a*c;
        let x1 = (-b +Math.sqrt(delta))/ (2*a);
        let x2 = (-b - Math.sqrt(delta))/ (2*a);
        if (delta > 0) { 
            return 'There are two roots: x1 = ' + x1 + ' ,x2 = '+x2 ;
        } 
        if (delta === 0){
            return 'There is 1 root: x = ' + -b/(2*a);
        } else {
            return 'no root!!'
        }
       
    }
}
function onClick(){
    const a = document.querySelector('#inputA').value;
    const b = document.querySelector('#inputB').value;
    const c = document.querySelector('#inputC').value;
    const result = quadraticEquation(a,b,c);

    const resultView = document.querySelector('#result');
    resultView.textContent = result;
}
//get the button
const button = document.querySelector('button');
//listen to event
button.addEventListener('click', onClick);