  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      function convert(a){
        var percent;
        if(a<5){
          percent=[a/5]*100;
        }else{
          percent=100;
        }
        var round= `${(percent)}%`;
        return round;
      };
      var x=$('.star-inner');
      for(var i=0;i<x.length;i++){
        x[i].style.width=convert(Math.random()*3+2);
      }
      var y=$('.count');
      for(var j=0;j<y.length;j++){
        y[j].innerHTML='('+Math.floor(Math.random()*800+10)+')';
      }
