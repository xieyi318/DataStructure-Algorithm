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
  

  

    x01 = [8, 32, 128, 512, 1024, 4096, 4192, 8192]  
    y01 = [1, 1, 10, 33, 141, 8155, 8718, 79196]  
    
    x02 = [8, 32, 128, 512, 1024, 4096, 4192, 8192]  
    y02 = [0, 1, 3, 11, 28, 385, 402, 1814]
    
  

    plt.scatter(x01[:], y01[:], 25, "blue")  
    plt.scatter(x02[:], y02[:], 25, "red")

    

    A1, B1, C1, D1= optimize.curve_fit(f_3, x01, y01)[0]  
    x1 = np.arange(0, 8200, 0.01)  
    y1 = A1*x1*x1*x1 + B1*x1*x1 + C1*x1 + D1 
    plt.plot(x1, y1, "blue", label="naive")  
  

    A2, B2, C2, D2= optimize.curve_fit(f_3, x02, y02)[0]  
    x2 = np.arange(0, 8200, 0.01)  
    y2 = A2*x2*x2*x2 + B2*x2*x2 + C2*x2 + D2  
    plt.plot(x2, y2, "red", label="sophisticated")  
    
    plt.legend(loc='upper left')
  
    plt.title("ThreeSum")  
    plt.xlabel('int')  
    plt.ylabel('ms')  
  
    plt.show()  
    return  

plot_test()