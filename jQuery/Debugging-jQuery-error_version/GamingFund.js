function rollOne(){
  var random= Math.floor(Math.random()*6)+1;
  return random;
}

function playFives(num){
 
  while(num>0){
    
    var x = 0;
    x = rollOne(); 
    if(x == 5){
      console.log("That's good luck!")
    }
    
    else{
      console.log(x);
    }
     num--;
  }
 
}

function playStatistics(){
  var min = rollOne();
  var max = rollOne();
  for(var i = 0; i<8; i++){
    var x = rollOne(); 
    if(x<min){
      min = x;
    }
    
    if(x>max){
      max = x;
    }
  }
  console.log(min);
  console.log(max);
}

function playStatistics2(){
  var min = rollOne();
  var max = rollOne();
  var sum = 0;
  for(var i = 0; i<8; i++){
    var x = rollOne(); 
    if(x<min){
      min = x;
    }
    
    if(x>max){
      max = x;
    }
    
    sum+=x;
  }
  console.log(min);
  console.log(max);
  console.log(sum);
}

function playStatistics3(num){
  var min = rollOne();
  var max = rollOne();
  var sum = 0;
  for(var i = 0; i<num; i++){
    var x = rollOne(); 
    if(x<min){
      min = x;
    }
    
    if(x>max){
      max = x;
    }
    
    sum+=x;
  }
  console.log(min);
  console.log(max);
  console.log(sum);
}

function playStatistics4(num){
  var min = rollOne();
  var max = rollOne();
  var sum = 0;
  for(var i = 0; i<num; i++){
    var x = rollOne(); 
    if(x<min){
      min = x;
    }
    
    if(x>max){
      max = x;
    }
    
    sum+=x;
  }
  console.log("Minimum",min);
  console.log("Maximum"+max);
  console.log("Sum",sum);
  
var avg = sum / num;
  console.log("Average",avg)
}




playStatistics4(3);


