import numpy as np  
import matplotlib.pyplot as plt  
from scipy import optimize  
  

def f_3(x, A, B, C, D):  
    return A*x*x*x + B*x*x + C*x + D  
  
def plot_test():  
  
    x01 = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]  
    y01 = [13,7,5,3,8,7,4,4,3,3,2,5,3,5,10,5,3,8,6,20,5]  
    
    x02 = [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20]   
    y02 = [28,10,10,9,8,10,10,9,8,7,8,6,9,11,10,17,8,18,25,37,11]
    
  

    plt.scatter(x01[:], y01[:], 25, "blue")  
    plt.scatter(x02[:], y02[:], 25, "red")

    

    A1, B1, C1, D1= optimize.curve_fit(f_3, x01, y01)[0]  
    x1 = np.arange(0, 21, 0.01)  
    y1 = A1*x1*x1*x1 + B1*x1*x1 + C1*x1 + D1 
    plt.plot(x1, y1, "blue", label="Merge")  
  

    A2, B2, C2, D2= optimize.curve_fit(f_3, x02, y02)[0]  
    x2 = np.arange(0, 21, 0.01)  
    y2 = A2*x2*x2*x2 + B2*x2*x2 + C2*x2 + D2  
    plt.plot(x2, y2, "red", label="Quick")  
    
    plt.legend(loc='upper left')
  
    plt.title("Cutoff")  
    plt.xlabel('cutoff')  
    plt.ylabel('Runtime(ms)')  
  
    plt.show()  
  
    return  

plot_test()