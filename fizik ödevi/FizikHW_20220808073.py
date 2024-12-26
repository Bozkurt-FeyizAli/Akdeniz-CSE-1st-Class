import math
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.colors import LinearSegmentedColormap

# Renk skalası tanımlama
# colors = [(0, 'pink'), (0.1, 'yellow'), (0.12, 'orange'),  (0.4, 'blue'), (0.8, 'purple'),  (1, 'purple')]
# custom_cmap = LinearSegmentedColormap.from_list('custom_cmap', colors)

# # Sabitler
# charge_str = input("Enter the charge in nanocoulombs: ")

# # Get the last digit of the charge as a string
# last_digit = charge_str[-1]

# # Convert the last digit to a float
# last_digit_float = float(last_digit)
# Q = last_digit_float * 1e-9
# k = 8.99e9  # N m^2/C^2, Coulomb sabiti
#   # C, yük (pozitif ya da negatif olmasına dikkat edin)

# # # # # 10x10'luk kare alanı oluştur
# x = np.linspace(0, 1, 10)
# y = np.linspace(0, 1, 10)
# X, Y = np.meshgrid(x, y)

# # Elektrik potansiyelini hesapla
# R = np.sqrt(X**2 + Y**2)  # Her noktadan yükün merkezine olan mesafe
# V = k * Q / R

# # Potansiyelin sonsuz ya da tanımsız olduğu yerleri işleme (örneğin, yükün olduğu nokta)
# V[R == 0] = 0

# # Elektrik potansiyeli değerlerini seviyeler olarak al
# V_levels = np.linspace(V.min()/5, V.max()/5, 50)


# # Grafik oluştur
# plt.figure(figsize=(8, 6))

# # Potansiyelin görselleştirilmesi
# plt.contourf(X, Y, V, levels=V_levels, cmap=custom_cmap)

# # Renk skalasının özelleştirilmesi
# plt.colorbar(label='Elektrik Potansiyeli (V)')

# plt.title('Elektrik Potansiyeli Haritası')
# plt.xlabel('x (m)')
# plt.ylabel('y (m)')
# plt.gca().set_aspect('equal', adjustable='box')
# plt.show()


# electric_potential = [[0 for _ in range(10)] for _ in range(10)]
# for i in range(10):
#     for j in range(10):
#         # Calculate the distance from the charge to the point
#         distance = math.sqrt(((i/10)**2 + (j/10)**2))
#         if distance == 0:
#             electric_potential[i][j] = 0
#             continue
#         # Calculate the electric field at the point
#         electric_potential[i][j] = k * Q / distance

# # for row in electric_field:
# #     print(row)
# PlotV1 = [electric_potential[i][0] for i in range(1, 10)]  # Skip electric_field[0][0]

# # Define indices (skipping the first point) and potentials
# indices = list(range(1, 10))
# potentials = PlotV1

# # Create the plot
# plt.figure(figsize=(10, 6))
# plt.plot(indices, potentials, marker='o', linestyle='-', color='b', label='Electric Potential')

# # Label the plot
# plt.title('Electric Potential Plot in the same y but different x points')
# plt.xlabel('Index for x ')
# plt.ylabel('Electric Potential (V)')
# plt.legend()
# plt.grid(True)

# # Show the plot
# plt.show()


# # PlotV2
# diagonal_indices = list(range(1, 10))  # Indices from 1 to 9
# diagonal_potentials = [electric_potential[i][i] for i in range(1, 10)]  # Diagonal potentials excluding the origin

# # Create the plot
# plt.figure(figsize=(10, 6))
# plt.plot(diagonal_indices, diagonal_potentials, marker='o', linestyle='-', color='b', label='Electric Potential')

# # Label the plot
# plt.title('Electric Potential Plot (Diagonal Points)')
# plt.xlabel('Index for x and y')
# plt.ylabel('Electric Potential (V)')
# plt.legend()
# plt.grid(True)

# # Show the plot
# plt.show()

# # f


# # # Define the electric potential function
# grid_size = 10  # Size of the grid (from 0 to 10, inclusive)

# # Generate a grid of coordinates
# x = np.linspace(0, 1, grid_size)
# y = np.linspace(0, 1, grid_size)
# X, Y = np.meshgrid(x, y)

# # Calculate the distance R from the origin (0,0)
# R = np.sqrt(X**2 + Y**2)

# # Initialize the potential array
# V = np.zeros_like(R)

# # Calculate the electric potential V
# for i in range(grid_size):
#     for j in range(grid_size):
#         distance = R[i, j]
#         if distance == 0:
#             V[i, j] = np.nan  # Avoid division by zero
#         else:
#             V[i, j] = k * Q / distance

# # Create a contour plot
# plt.contour(X, Y, V, levels=41, cmap='viridis')  # Adjust the number of levels as needed

# # Add labels and a title
# plt.xlabel('X')
# plt.ylabel('Y')
# plt.title('Equipotential Lines')

# # Add a color bar to show the potential values
# plt.colorbar(label='Electric Potential (V)')

# # Show the plot
# plt.grid(True)
# plt.show()


# v_map = {}

# # Assume V is a 2D list (array) with values
# V = [[i + j for j in range(10)] for i in range(10)]  # Example 2D list initialization, replace with actual data

