import React from "react";

const categories =(props)=>{
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped table-primary text-center"}>
                        <thead className={"table-dark"}>
                        <tr>
                            <th scope={"col"}>Category name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {props.categories.map((category) => {
                            return (
                                <tr>
                                    <td>{category}</td>
                                </tr>
                            );
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}
export default categories;