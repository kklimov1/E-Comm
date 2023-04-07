
export const environment = {
    production: true,
    withCredentials: true,
    baseUrl: "http://ec2-54-87-34-154.compute-1.amazonaws.com:8080",
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': 'http://statichostingmysite.s3-website-us-east-1.amazonaws.com',
        'Origin': 'http://ec2-54-87-34-154.compute-1.amazonaws.com:8080',
        'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With'
      }
};