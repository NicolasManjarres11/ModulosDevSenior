
export interface Recipe {
    id: number;
    title: string;
    description: string;
    ingredients: Ingredient[];
    instructions?: String[];
    imageUrl: string;
}

export interface Ingredient {
    name: string;
    quantity: number;
    units: string;
}