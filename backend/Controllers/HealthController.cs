using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace Valentinajemuovic.SkyTravel.Backend.Controllers;

[ApiController]
[AllowAnonymous]
[Route("")]
public class HealthController : ControllerBase
{
    [HttpGet("health")]
    public IActionResult CheckHealth()
    {
        return Ok(new { status = "UP" });
    }
}
