import axiosInstance from './axiosInstance';

export interface Order {
    orderID: string;
    productID: string;
    customerID: string;
    quantity: number;
    total: number;
}

export interface CreateOrderInput {
    productID: string;
    customerID: string;
    quantity: number;
    total: number;
}

const mapOrder = (order: any): Order => ({
    orderID: order.orderID ?? order.id ?? '',
    productID: order.productID,
    customerID: order.customerID,
    quantity: typeof order.quantity === 'number' ? order.quantity : Number(order.quantity ?? 0),
    total: typeof order.total === 'number' ? order.total : Number(order.total ?? 0),
});

export const createOrder = async (orderData: CreateOrderInput): Promise<Order> => {
    try {
        const response = await axiosInstance.post('/orders/create', orderData);
        return mapOrder(response.data);
    } catch (error: any) {
        console.error('Error creating order:', error);
        throw new Error(error.response?.data?.message || 'Failed to create order');
    }
};

export const getAllOrders = async (): Promise<Order[]> => {
    try {
        const response = await axiosInstance.get('/orders/all');
        if (!Array.isArray(response.data)) {
            return [];
        }
        return response.data.map(mapOrder);
    } catch (error: any) {
        console.error('Error fetching orders:', error);
        throw new Error(error.response?.data?.message || 'Failed to fetch orders');
    }
};