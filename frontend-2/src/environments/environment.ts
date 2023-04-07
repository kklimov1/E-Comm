export const environment = {
    production: true,
    withCredentials: true,
    baseUrl: "http://ec2-54-87-34-154.compute-1.amazonaws.com:7777",
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://statichostingmysite.s3-website-us-east-1.amazonaws.com',
        'Origin': 'http://ec2-54-87-34-154.compute-1.amazonaws.com:7777',
        'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With'
      }
};
/*export const environment = {
    production: false,
    withCredentials: true,
    baseUrl: "http://localhost:5432",
    headers: {
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': 'http://localhost:4200',
},
};*/
