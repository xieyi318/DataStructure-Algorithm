import math
import numpy as np  
import matplotlib.pyplot as plt  
from scipy import optimize  
  

def f_1(x, A, B):  
    return A*x + B  
  

def f_2(x, A, B, C):  
    return A*x*x + B*x + C  
  

def f_3(x, A, B, C, D):  
    return A*x*x*x + B*x*x + C*x + D  
  
def plot_test():  
  

  
 
    x01 = [ 512, 1024, 4096, 4192, 8192]  
    y01 = [  33, 141, 8155, 8718, 79196]
    y02=[1,1,1,1,1]
    x02=[1,1,1,1,1]
    
    for i in range(0,5):
        y02[i]=math.log(y01[i])
        x02[i]=math.log(x01[i])
        
  
    plt.scatter(x02[:], y02[:], 25, "red")

    
  

    A2, B2= optimize.curve_fit(f_1, x02, y02)[0]  
    x2 = np.arange(0, 10, 0.01)  
    y2 = A2*x2 + B2  
    plt.plot(x2, y2, "red", label="log")  
    
    plt.legend(loc='upper left')
  
    plt.title("log-log diagram")  
    plt.ylabel('log(Time(n))')
    plt.xlabel('log(n)')
  
    plt.show()
    print("slope=",A2)
  
    return  

plot_test()