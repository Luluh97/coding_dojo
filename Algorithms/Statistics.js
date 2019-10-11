function rollOne(){
  var count=0;
  var random= Math.floor(Math.random()*20)+1;
  var min = random;
  var max = random;
  var sum = 0;
  while(true){
   
    var temp=random;
    random = Math.floor(Math.random()*20)+1;
     if(temp<min){
      min = temp;
    }
    if(temp>max){
      max = temp;
    }
    sum+=temp;
    
    count++;
    if(random == temp){
      console.log(count);
      console.log(max);
      console.log(min);
      console.log(sum);
      var avg = sum / count;
      console.log(avg);
      break;
      
    }
    
  }  
}

rollOne()

