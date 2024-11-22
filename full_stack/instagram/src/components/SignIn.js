import React from 'react';
import img1 from '../images/img1.png';

function signin() {
    return (
    <div className='flex flex-col items-center border-2 border-[black]'>
        <div className="flex border-[1px] border-[red]">
            <div><img src={img1}/></div>
            <div>Form</div>
        </div>
        <div className='border-[1px] border-[green]'>Footer div</div>
    </div>
    );
}

export default signin;