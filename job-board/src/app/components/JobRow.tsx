export default function JobRow() {
    return (
        <>
            <div className="bg-white p-6 rounded-lg shadow-sm relative">
                <div className="absolute top-2 right-4">
                    
                </div>
                <div className="flex grow gap-4">
                    <div className="content-center">
                        <img
                            className="size-12" 
                            src="https://upload.wikimedia.org/wikipedia/commons/1/19/Spotify_logo_without_text.svg" alt="" />
                    </div>
                    <div className="grow sm:flex">
                        <div className="grow">
                            <div className="text-gray-500 text-sm">Spotify</div>
                            <div className="font-bold text-lg mb-1">Product Designer</div>
                            <div className="text-gray-400 text-sm">Remote &middot; New York, US &middot; Full time</div>
                        </div>
                        <div className="content-end text-gray-500 text-sm">
                            2 hours ago
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}